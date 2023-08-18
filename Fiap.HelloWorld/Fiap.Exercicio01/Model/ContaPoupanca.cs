using Fiap.Exercicio01.Exceptions;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Fiap.Banco.Model
{
    internal class ContaPoupanca : Conta, IContaInvestimento
    {
        //readonly -> só pode atribuir valor na declaração ou no construtor
        private readonly decimal _rendimento;

        public decimal Taxa { get; set; }

        public ContaPoupanca(decimal rendimento)
        {
            _rendimento = rendimento;
        }

        public decimal CalculaRetornoInvestimento()
        {
            return _rendimento * Saldo;
        }

        //verifica se o saldo é suficiente, se for deve descontar também a Taxa de retirada, se não, lance uma exceção;
        public override void Retirar(decimal valor)
        {
            if (valor + Taxa > Saldo)
            {
                throw new SaldoInsuficienteException(Saldo - Taxa);
            }
            base.Retirar(valor + Taxa);
        }
    }
}
