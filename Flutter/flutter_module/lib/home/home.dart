import 'package:app/home/color.dart';
import 'package:app/router.dart';
import 'package:flutter/material.dart';
import 'package:flutter_boost/flutter_boost.dart';

class HomeRouter with PageRouter {
  @override
  Map<String, FlutterBoostRouteFactory> routers = {
    'home': (settings, uniqueId) {
      return PageRouteBuilder(
          settings: settings,
          opaque: false,
          barrierColor: Colors.red,
          fullscreenDialog: true,
          pageBuilder: (_, __, ___) {
            return const MyApp();
          });
    }
  };
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // Try running your application with "flutter run". You'll see the
        // application has a blue toolbar. Then, without quitting the app, try
        // changing the primarySwatch below to Colors.green and then invoke
        // "hot reload" (press "r" in the console where you ran "flutter run",
        // or press Run > Flutter Hot Reload in a Flutter IDE). Notice that the
        // counter didn't reset back to zero; the application is not restarted.
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  late List<Widget> widgets;

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    widgets = [StatelessColor(), StatelessColor()];
  }

  void _incrementCounter() {
    setState(() {
      widgets.insert(1, widgets.removeAt(0));
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: SafeArea(
          child: Row(
        children: widgets,
      )),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: const Icon(Icons.add),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
