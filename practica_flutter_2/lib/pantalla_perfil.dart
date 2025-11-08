import 'package:flutter/material.dart';

// Pantalla del perfil del usuario
class PantallaPerfil extends StatefulWidget {
  PantallaPerfil({super.key});

  @override
  State<PantallaPerfil> createState() => _PantallaPerfilState();
}

class _PantallaPerfilState extends State<PantallaPerfil> {
  String _nombreUsuario = "Invitado"; // nombre inicial

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text(
            'Perfil de $_nombreUsuario',
            style: const TextStyle(fontSize: 24),
          ),
          const SizedBox(height: 20),
          // Botón para editar el nombre
          ElevatedButton(
            onPressed: () async {
              final nombre = await Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => const EditarPerfilScreen()),
              );
              // si se escribió algo, se actualiza el nombre
              if (nombre != null && nombre.toString().trim().isNotEmpty) {
                setState(() {
                  _nombreUsuario = nombre;
                });
              }
            },
            child: const Text('Editar perfil'),
          ),
        ],
      ),
    );
  }
}

// Pantalla donde se edita el nombre
class EditarPerfilScreen extends StatefulWidget {
  const EditarPerfilScreen({super.key});

  @override
  State<EditarPerfilScreen> createState() => _EditarPerfilScreenState();
}

class _EditarPerfilScreenState extends State<EditarPerfilScreen> {
  final TextEditingController _controller = TextEditingController(); // para leer el texto

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Editar perfil')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            // Campo para escribir el nombre
            TextField(
              controller: _controller,
              decoration: const InputDecoration(labelText: 'Nombre'),
            ),
            const SizedBox(height: 20),
            // Botón para guardar
            ElevatedButton(
              onPressed: () {
                // regresa a la pantalla anterior con el texto
                Navigator.pop(context, _controller.text);
              },
              child: const Text('Guardar'),
            ),
          ],
        ),
      ),
    );
  }
}
