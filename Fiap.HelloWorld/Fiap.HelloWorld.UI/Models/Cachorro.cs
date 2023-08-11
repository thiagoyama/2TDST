using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fiap.HelloWorld.UI.Models
{
    internal class Cachorro : Animal, IMamifero
    {
        public string Nome { get; set; }
        public string Raca { get; set; }
        public string Dono { get; set; }

        //Construtor que "chama" o construtor de animal (Peso, Idade)
        public Cachorro(float peso, int idade) : base(peso, idade)
        {

        }

        //Construtor que recebe peso, idade e o nome
        public Cachorro(float peso, int idade, string nome) : base(peso, idade)
        {
            Nome = nome;
        }

        public void Amamentar(int quantidade)
        {
            //validar se a quantidade é maior do que zero
            if (quantidade < 1)
            {
                throw new ArgumentException("Quantidade deve ser maior ou igual a 1");
            }
            Console.WriteLine($"Cachorro amamentando {quantidade} filhos");
        }

        public void Parir()
        {
            Console.WriteLine("Cachorro dando cachorrinhos");
        }
    }
}
