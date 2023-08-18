using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fiap.Banco.Model
{
    //Classe abstrata: não pode ser instanciada e pode ter métodos abstratos
    internal abstract class Conta
    {
        public int Agencia { get; set; }
        public int Numero { get; set; }
        public DateTime DataAbertura { get; set; }
        public decimal Saldo { get; set; }

        public virtual void Depositar(decimal valor)
        {
            if (valor <= 0)
            {
                throw new ArgumentException("Valor não pode ser negativo ou zero");
            }
            Saldo += valor;
        }

        public virtual void Retirar(decimal valor)
        {
            if (valor <= 0)
            {
                throw new ArgumentException("Valor não pode ser negativo ou zero");
            }
            Saldo -= valor;
        }
    }
}
