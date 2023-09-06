namespace Fiap.Web.Aula02.Models
{
    public class Veiculo
    {
        public int Id { get; set; }
        public string? Modelo { get; set; }
        public string? Marca { get; set; }
        public bool Disponivel { get; set; }
        public long Km { get; set; }
        public int Ano { get; set; }
        public string? Placa { get; set; }
    }
}
