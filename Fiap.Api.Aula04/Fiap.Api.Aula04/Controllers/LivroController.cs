using Fiap.Api.Aula04.Models;
using Fiap.Api.Aula04.Persistencia;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Fiap.Api.Aula04.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class LivroController : ControllerBase
    {
        private LivrariaContext _context;

        public LivroController(LivrariaContext context)
        {
            _context = context;
        }

        [HttpGet]
        public ActionResult<List<Livro>> Get()
        {
            return _context.Livros.ToList();
        }

        [HttpPost]
        public ActionResult<Livro> Create(Livro livro)
        {
            _context.Livros.Add(livro);
            _context.SaveChanges();
            return CreatedAtAction("Get", new {id = livro.Id}, livro);
        }

    }
}
