import 'package:flutter/material.dart';
import 'pantalla_inicio.dart';
import 'pantalla_usuarios.dart';
import 'pantalla_config.dart';
import 'pantalla_perfil.dart';

// App principal
void main() => runApp(const MyApp());

// Clase principal de la app
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false, // quita la etiqueta de debug
      title: 'Navegación Inferior',
      home: MyHomePage(), // pantalla principal
    );
  }
}

// Esta clase maneja las pestañas
class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key});

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

// Estado que controla las pestañas
class _MyHomePageState extends State<MyHomePage> {
  int _selectedIndex = 0; // para saber qué pestaña está seleccionada

  // Lista con las pantallas
  late final List<Widget> _pages = [
    const PantallaInicio(),
    const PantallaUsuarios(),
    const PantallaConfig(),
    PantallaPerfil(), // pestaña de perfil
  ];

  // cuando se toca una pestaña
  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index; // cambia el índice
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Navegación Inferior')), // título arriba
      body: _pages[_selectedIndex], // muestra la pantalla actual
      bottomNavigationBar: BottomNavigationBar(
        currentIndex: _selectedIndex,
        onTap: _onItemTapped,
        type: BottomNavigationBarType.fixed, // para 4 botones
        items: const [
          BottomNavigationBarItem(icon: Icon(Icons.home), label: 'Inicio'),
          BottomNavigationBarItem(icon: Icon(Icons.people), label: 'Usuarios'),
          BottomNavigationBarItem(icon: Icon(Icons.settings), label: 'Config'),
          BottomNavigationBarItem(icon: Icon(Icons.person), label: 'Perfil'),
        ],
      ),
    );
  }
}
