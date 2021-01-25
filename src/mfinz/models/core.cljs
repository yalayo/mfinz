(ns mfinz.models.core)

(def info [{:account {:type :assets :name "Bank"} :amount 100} {:account {:type :equity :name "Capital"} :amount 50} {:account {:type :liabilities :name "Debts"} :amount 50}])

(defn account-value [kind info]
	(reduce + (map #(get % :amount)
		(filter #(let [t (get-in % [:account :type])]
	                 (if (= t kind) true)) info))))

(defn balanced? [info]
	(let [assets (account-value :assets info)
				liabilities (account-value :liabilities info)
				capital (account-value :equity info)]
				(if (= assets (+ capital liabilities)) true false)))

(balanced? info)

(def movement [{:account {:id 1} :column :debit :amount 100} {:account {:id 2} :column :debit :amount 100} {:account {:id 3} :column :credit :amount 200}])

(defn column-value [kind info]
	(reduce + (map #(get % :amount)
		(filter #(let [t (get % :column)]
	                 (if (= t kind) true)) info))))

(defn valid? [movement]
	(let [debit (column-value :debit movement)
				credit (column-value :credit movement)]
		(if (= debit credit) true false)))

(valid? movement)
