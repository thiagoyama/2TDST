namespace Fiap.Web.Aula02.Models
{
    public class Motorista
    {
        public int Id { get; set; }
        public string? Nome { get; set; }
        public DateTime DataNascimento { get; set; }
        public Genero Genero { get; set; }
    }

    public enum Genero
    {
        Feminino, Masculino, Outros
    }
}
