// See https://aka.ms/new-console-template for more information
using Fiap.HelloWorld.UI;
using Fiap.HelloWorld.UI.Models;

Console.WriteLine("Hello, World!");

//Instanciar um Aluno
Aluno aluno = new Aluno();

//Atribuir o nome ao aluno
aluno.Nome = "João";
aluno.Cpf = "1234234";

//Exibir o nome
Console.WriteLine(aluno.Nome);
Console.WriteLine(aluno.Cpf);

//Instanciar um Cachorro
Cachorro dog = new Cachorro(15, 5, "Brutus")
{
    Dono = "Thiago"
};

//Exibir o nome, peso, idade e dono
Console.WriteLine($"Nome: {dog.Nome}, Peso: {dog.Peso}, Idade: {dog.Idade}, Dono: {dog.Dono}");

dog.Idade = 10;
Console.WriteLine(dog.Idade);

//Fazer o aluno andar!
aluno.Andar();
aluno.Andar("FIAP");

//Setar o genero do aluno
aluno.Genero = Genero.Masculino;
//Exibir o genero
Console.WriteLine(aluno.Genero);

//Criar uma lista de Cachorro
IList<Cachorro> lista = new List<Cachorro>();

//Adicionar 2 dogs na lista
var dog1 = new Cachorro(15, 2, "Marrie");
var dog2 = new Cachorro(5, 8, "Rex");

lista.Add(dog1);
lista.Add(dog2);

//Exibir a quantidade de dogs na lista
Console.WriteLine(lista.Count);

//Exibir os dados dos dogs da lista
foreach (var c in lista)
{
    Console.WriteLine($"Nome: {c.Nome}, Idade: {c.Idade}, Raça: {c.Raca} ");
}

//Chamar o método amamentar (tratar a exception)
try
{
    dog.Amamentar(-1);
}
catch (ArgumentException e) 
{
    Console.WriteLine(e.Message);
}
