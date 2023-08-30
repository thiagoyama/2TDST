using Microsoft.AspNetCore.Mvc;

namespace Fiap.Web.Aula01.Controllers
{
    public class CheckpointController : Controller
    {
        public IActionResult Calcular()
        {
            return View();
        }
    }
}
