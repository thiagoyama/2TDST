using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Fiap.Api.Aula04.Models
{
    [Table("Tb_Livro")]
    public class Livro
    {
        public int Id { get; set; }
        public string Titulo { get; set; }
        public string Autor { get; set; }
        public int QuantidadePaginas { get; set; }
        public string Sinopse { get; set; }

        [Column("dt_lancamento"), DataType(DataType.Date)]
        public DateTime DataLancamento { get; set; }
        public string Genero { get; set; }
    }
}
