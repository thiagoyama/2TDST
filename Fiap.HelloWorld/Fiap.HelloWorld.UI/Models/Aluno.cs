using Fiap.HelloWorld.UI.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Net.Mime.MediaTypeNames;

namespace Fiap.HelloWorld.UI
{
    public class Aluno : Pessoa
    {
        //Propriedades
        public DateTime DataMatricula { get; set; }
        public bool Ativo { get; set; }

    }
}




    