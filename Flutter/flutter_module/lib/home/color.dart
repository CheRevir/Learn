import 'dart:math';

import 'package:flutter/material.dart';

class UniqueColorGenerator {
  List<Color> list = [
    Colors.blue,
    Colors.yellow,
    Colors.red,
    Colors.black54,
    Colors.greenAccent,
    Colors.pinkAccent,
  ];

  Random random = Random();

  Color getColor() {
    return list[random.nextInt(list.length)];
  }
}

class StatelessColor extends StatelessWidget {
  StatelessColor({super.key});

  final Color color = UniqueColorGenerator().getColor();

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: 100,
      height: 100,
      child: Container(
        color: color,
      ),
    );
  }


}

class StatefulColor extends StatefulWidget {
  const StatefulColor({super.key});

  @override
  State<StatefulWidget> createState() => StatefulColorState();
}

class StatefulColorState extends State<StatefulColor> {
  final Color color = UniqueColorGenerator().getColor();

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: 100,
      height: 100,
      child: Container(
        color: color,
      ),
    );
  }
}
