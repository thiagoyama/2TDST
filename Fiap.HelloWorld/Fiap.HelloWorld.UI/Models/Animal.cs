using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fiap.HelloWorld.UI.Models
{
    internal class Animal
    {
        public char Genero { get; set; }
        public int Idade { get; set; }
        public float Peso { get; set; }

        //Criar um construtor com Peso e Idade
        public Animal(float peso, int idade)
        {
            Idade = idade;
            Peso = peso;
        }
    }
}