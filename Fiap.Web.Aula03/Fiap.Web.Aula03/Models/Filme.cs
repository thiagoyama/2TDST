using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Fiap.Web.Aula03.Models
{
    [Table("Tb_Filme")]
    public class Filme
    {
        [Column("Id")]
        public int FilmeId { get; set; }
        
        [Required, MaxLength(40)]
        public string? Titulo { get; set; }

        [MaxLength(100)]
        public string? Sinopse { get; set; }
        
        public CategoriaFilme Categoria { get; set; }
        
        [Column("Dt_Lancamento")]
        public DateTime DataLancamento { get; set; }
        
        [Required]
        public bool Disponivel { get; set; }
        
        [Required]
        public int Duracao { get; set; }
        
        public decimal Bilheteria { get; set; }
    }

    public enum CategoriaFilme
    {
        Comedia, Terror, Aventura, Romance, Suspense
    }
}
