using Microsoft.AspNetCore.Mvc;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Fiap.Web.Aula03.Models
{
    [Table("Tb_Filme")]
    public class Filme
    {
        [Column("Id"), HiddenInput]
        public int FilmeId { get; set; }
        
        [Required, MaxLength(40), Display(Name = "Título")]
        public string? Titulo { get; set; }

        [MaxLength(100)]
        public string? Sinopse { get; set; }
        
        public CategoriaFilme Categoria { get; set; }
        
        [Column("Dt_Lancamento"), Display(Name = "Data de Lançamento"), DataType(DataType.Date)]
        public DateTime DataLancamento { get; set; }
        
        [Required, Display(Name = "Disponível")]
        public bool Disponivel { get; set; }
        
        [Required, Display(Name = "Duração")]
        public int Duracao { get; set; }
        
        public decimal Bilheteria { get; set; }
    }

    public enum CategoriaFilme
    {
        Comedia, Terror, Aventura, Romance, Suspense
    }
}
