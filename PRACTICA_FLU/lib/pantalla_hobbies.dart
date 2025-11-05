import 'package:flutter/material.dart';

class PantallaHobbies extends StatelessWidget {
  const PantallaHobbies({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Mis Hobbies')),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            const Text(
              'Algunas cosas que me gustan:',
              style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 20),
            Row(
              children: [
                Image.network(
                  'https://cdn-icons-png.flaticon.com/512/29/29302.png',
                  width: 50,
                ),
                const SizedBox(width: 10),
                const Text('Leer libros'),
              ],
            ),
            const SizedBox(height: 15),
            Row(
              children: [
                Image.network(
                  'https://cdn-icons-png.flaticon.com/512/861/861512.png',
                  width: 50,
                ),
                const SizedBox(width: 10),
                const Text('Jugar videojuegos'),
              ],
            ),
            const SizedBox(height: 15),
            Row(
              children: [
                Image.network(
                  'https://cdn-icons-png.flaticon.com/512/727/727245.png',
                  width: 50,
                ),
                const SizedBox(width: 10),
                const Text('Escuchar música'),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
