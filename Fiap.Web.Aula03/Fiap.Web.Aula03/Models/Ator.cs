using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Fiap.Web.Aula03.Models
{
    [Table("Tbl_Ator")]
    public class Ator
    {
        [Column("Id")]
        public int AtorId { get; set; }

        [Required, MaxLength(80)]
        public string Nome { get; set; }

        [DataType(DataType.Date)]
        public DateTime DataNascimento { get; set; }
        
        public Nacionalidade Nacionalidade { get; set; }
        public bool Premiado { get; set; }

        //N:M
        public IList<FilmeAtor> FilmesAtores { get; set; }
    }

    public enum Nacionalidade
    {
        Brasileira, Americana, Italiana, Inglesa
    }
}
