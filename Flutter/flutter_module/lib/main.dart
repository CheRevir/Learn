import 'package:app/home/home.dart';
import 'package:app/router.dart';
import 'package:flutter/material.dart';
import 'package:flutter_boost/flutter_boost.dart';
import 'package:get/get.dart';

void main() {
  AppWidgetsFlutterBinding();
  RouterManager.registerAll([
    HomeRouter(),
  ]);
  runApp(App(router: RouterManager.getPageRouterFactory()));
}

class AppWidgetsFlutterBinding extends WidgetsFlutterBinding
    with BoostFlutterBinding {}

class App extends StatelessWidget {
  final Map<String, FlutterBoostRouteFactory> router;

  const App({super.key, required this.router});

  @override
  Widget build(BuildContext context) {
    return FlutterBoostApp(
      _routeFactory,
      appBuilder: _appBuilder,
    );
  }

  Route<dynamic>? _routeFactory(RouteSettings settings, String? uniqueId) {
    FlutterBoostRouteFactory? factory = router[settings.name];
    if (factory == null) {
      return null;
    }
    return factory(settings, uniqueId);
  }

  Widget _appBuilder(Widget widget) {
    return GetMaterialApp(home: widget);
    return MaterialApp(
      home: widget,
      debugShowCheckedModeBanner: true,
      builder: (_, __) {
        return widget;
      },
    );
  }
}
