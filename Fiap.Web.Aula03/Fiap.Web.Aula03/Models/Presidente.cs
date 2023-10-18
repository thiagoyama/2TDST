using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Fiap.Web.Aula03.Models
{
    [Table("Tbl_Presidente")]
    public class Presidente
    {
        [Column("Id")]
        public int PresidenteId { get; set; }
        [Required]
        public string? Nome { get; set; }
        public DateTime DataNascimento { get; set; }
    }
}
