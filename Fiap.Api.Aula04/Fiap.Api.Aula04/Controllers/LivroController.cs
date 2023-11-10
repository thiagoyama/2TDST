using Fiap.Api.Aula04.Models;
using Fiap.Api.Aula04.Persistencia;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

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

        //GET api/livro/1
        [HttpGet("{id}")]
        public ActionResult<Livro> Get(int id)
        {
            var livro = _context.Livros.Find(id);
            if (livro == null)
            {
                return NotFound();
            }
            return Ok(livro);
        }

        //PUT api/livro/1
        [HttpPut("{id}")]
        public ActionResult<Livro> Put(int id, Livro livro)
        {
            var busca = _context.Livros.Find(id);
            if (busca == null)
            {
                return NotFound();
            }
            //Retira o objeto busca do gerenciamento do DbContext
            _context.Entry<Livro>(busca).State = EntityState.Detached;
            livro.Id = id;
            _context.Livros.Update(livro);
            _context.SaveChanges();
            return Ok(livro);
        }

        //DELETE api/livro/1
        [HttpDelete("{id}")]
        public ActionResult Delete(int id)
        {
            var livro = _context.Livros.Find(id);
            if (livro  == null)
            {
                return NotFound();
            }
            _context.Livros.Remove(livro);
            _context.SaveChanges();
            return NoContent();
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
