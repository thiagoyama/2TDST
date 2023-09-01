using Fiap.Web.Aula01.Models;
using Microsoft.AspNetCore.Mvc;

namespace Fiap.Web.Aula01.Controllers
{
    public class CheckpointController : Controller
    {
        [HttpGet] //Abrir a página com o formulário HTML
        public IActionResult Calcular() // localhost:1232/checkpoint/calcular -> Views/Checkpoint/Calcular.cshtml
        {
            return View();
        }

        [HttpPost]
        public IActionResult Calcular(Checkpoint cp)
        {
            //Calcular a média
            float media = (cp.Cp1 + cp.Cp2 + cp.Cp3)/3;
            //Enviar a média para a view
            ViewData["media"] = media;
            cp.Media = media;
            //Enviar o objeto Checkpoint para a view
            return View(cp);
            //return RedirectToAction("Calcular");
        }
    }
}
