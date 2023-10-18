using System.ComponentModel.DataAnnotations.Schema;

namespace Fiap.Web.Aula03.Models
{
    [Table("Tbl_Filme_Ator")]
    public class FilmeAtor
    {
        public int FilmeId { get; set; }
        public Filme Filme { get; set; }
        public Ator Ator { get; set; }
        public int AtorId { get; set; }
    }
}
