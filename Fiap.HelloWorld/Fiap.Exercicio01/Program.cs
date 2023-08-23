using Fiap.Banco.Model;
using Fiap.Exercicio01.Exceptions;

//Instanciar uma ContaCorrente
var cc = new ContaCorrente()
{
    Agencia = 112,
    Numero = 213,
    Saldo = 10,
    Tipo = TipoConta.Comum,
    DataAbertura = new DateTime(2001, 1, 20)
};

//Instanciar uma ContaPoupanca
var cp = new ContaPoupanca(0.6m)
{
    Agencia = 112,
    Numero = 565,
    Saldo = 10,
    Taxa = 1,
    DataAbertura = DateTime.Now
};

//Chamar os métodos Depositar
cc.Depositar(100);
cp.Depositar(5);

//Exibir o saldo
Console.WriteLine($"Saldo da conta corrente: {cc.Saldo}");
Console.WriteLine($"Saldo da conta poupança: {cp.Saldo}");

//Chamar os métodos Retirar
//Ler o valor que será retirado da conta corrente
Console.WriteLine("Digite o valor para saque:");
var valor = Convert.ToDecimal(Console.ReadLine());
try
{
    cc.Retirar(valor);
}
catch (Exception e)
{
    Console.WriteLine(e.Message);
}
//catch (ArgumentException e)
//{
//    Console.WriteLine(e.Message);
//}
cp.Retirar(4);

//Exibir o saldo
Console.WriteLine($"Saldo da conta corrente: {cc.Saldo}");
Console.WriteLine($"Saldo da conta poupança: {cp.Saldo}");
