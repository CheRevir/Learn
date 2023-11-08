import 'package:flutter/widgets.dart';
import 'package:flutter_boost/flutter_boost.dart';
import 'package:get/get.dart';

mixin PageRouter {
  abstract Map<String, FlutterBoostRouteFactory> routers;
}

class RouterManager {
  static final List<PageRouter> _routers = [];

  static void register(PageRouter router) {
    _routers.add(router);
  }

  static void registerAll(List<PageRouter> router) {
    _routers.addAll(router);
  }

  static List<PageRouter> getPageRouters() {
    return _routers;
  }

  static Map<String, FlutterBoostRouteFactory> getPageRouterFactory() {
    Map<String, FlutterBoostRouteFactory> factory = {};
    var list = _routers.map((e) => e.routers);
    for (var element in list) {
      factory.addEntries(element.entries);
    }
    return factory;
  }
}

/*

class Router{
  static final RouteSettings ()
}*/
