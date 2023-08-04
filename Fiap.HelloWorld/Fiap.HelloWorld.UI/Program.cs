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