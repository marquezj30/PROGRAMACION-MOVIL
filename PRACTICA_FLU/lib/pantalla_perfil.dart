import 'package:flutter/material.dart';

class PantallaPerfil extends StatelessWidget {
  const PantallaPerfil({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Mi Perfil')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            const CircleAvatar(
              radius: 60,
              backgroundImage: NetworkImage(
                'https://i.pravatar.cc/300',
              ),
            ),
            const SizedBox(height: 20),
            const Text(
              'johan marquez',
              style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
            ),
            const Text(
              'Estudiante de Ingeniería de Software',
              style: TextStyle(color: Colors.grey),
            ),
            const SizedBox(height: 20),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: const [
                Icon(Icons.email, color: Colors.teal),
                SizedBox(width: 10),
                Text('johanmarquezzuniga@gmail.com'),
              ],
            ),
            const SizedBox(height: 10),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: const [
                Icon(Icons.phone, color: Colors.teal),
                SizedBox(width: 10),
                Text('+51 123456789'),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
