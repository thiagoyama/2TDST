using Fiap.Api.Aula04.Models;
using Microsoft.EntityFrameworkCore;

namespace Fiap.Api.Aula04.Persistencia
{
    public class LivrariaContext : DbContext
    {
        public DbSet<Livro> Livros { get; set; }

        public LivrariaContext(DbContextOptions op):base(op)
        {
            
        }
    }
}
