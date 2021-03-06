import {AppRegistry} from 'react-native';
import {name as appName} from './app.json';
import {npmDeps} from "./npm_deps.js";

// you can add other items to npmDeps here
// npmDeps["./assets/logo.png"]= require("./assets/logo.png");

// this url points to a file generated by the cljs compiler in the output-dir of your app
//var options = {optionsUrl: "http://localhost:9500/cljs-out/ios/cljsc_opts.json"};
var options = {optionsUrl: "http://10.0.2.2:9500/cljs-out/android/cljsc_opts.json"};

var figBridge = require("react-native-figwheel-bridge");
figBridge.shimRequire(npmDeps);
AppRegistry.registerComponent(appName,
                              () => figBridge.createBridgeComponent(options));
