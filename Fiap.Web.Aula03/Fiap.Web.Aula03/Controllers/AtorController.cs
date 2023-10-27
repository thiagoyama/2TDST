using Fiap.Web.Aula03.DataBase;
using Fiap.Web.Aula03.Models;
using Microsoft.AspNetCore.Mvc;

namespace Fiap.Web.Aula03.Controllers
{
    public class AtorController : Controller
    {
        private StreamingContext _context;

        public AtorController(StreamingContext context)
        {
            _context = context;
        }

        [HttpGet]
        public IActionResult Cadastrar()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Cadastrar(Ator ator)
        {
            _context.Atores.Add(ator);
            _context.SaveChanges();
            TempData["msg"] = "Ator registrado";
            return RedirectToAction("Index");
        }

        public IActionResult Index()
        {
            var atores = _context.Atores.ToList();
            return View(atores);
        }
    }
}
