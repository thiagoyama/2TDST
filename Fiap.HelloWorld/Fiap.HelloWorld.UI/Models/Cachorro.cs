using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fiap.HelloWorld.UI.Models
{
    internal class Cachorro : Animal
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
    }
}
