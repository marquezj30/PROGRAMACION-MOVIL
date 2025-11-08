import 'package:flutter/material.dart';

// Pantalla de configuración
class PantallaConfig extends StatelessWidget {
  const PantallaConfig({super.key});

  @override
  Widget build(BuildContext context) {
    return const Center(
      child: Text(
        'Configuración de la App',
        style: TextStyle(fontSize: 24),
      ),
    );
  }
}
