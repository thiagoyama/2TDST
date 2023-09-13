using System.ComponentModel.DataAnnotations;

namespace Fiap.Web.Aula02.Models
{
    public class Veiculo
    {
        public int Id { get; set; }
        public string? Modelo { get; set; }
        public string? Marca { get; set; }

        [Display(Name = "Disponível")] //Altera o texto do label (HTML)
        public bool Disponivel { get; set; }
        public long Km { get; set; }

        [Display(Name = "Ano de Fabricação")] //Altera o texto do label (HTML)
        public int Ano { get; set; }
        public string? Placa { get; set; }

        public TipoVeiculo Tipo { get; set; }

    }

    public enum TipoVeiculo
    {
        Suv, Sedan, Hatch, Sport, Utilitario
    }
}
