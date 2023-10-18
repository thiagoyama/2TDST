using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Fiap.Web.Aula03.Models
{
    [Table("Tbl_Produtora")]
    public class Produtora
    {
        [Column("Id")]
        public int ProdutoraId { get; set; }
        [Required]
        public string? Nome { get; set; }
        public int Premios { get; set; }
        public bool Ativo { get; set; }

        //1:1
        public Presidente Presidente { get; set; }
        public int PresidenteId { get; set; }

        //1:N
        public IList<Filme> Filmes { get; set; }
    }
}
