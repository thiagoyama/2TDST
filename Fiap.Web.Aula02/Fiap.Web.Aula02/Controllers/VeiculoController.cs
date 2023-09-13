using Fiap.Web.Aula02.Models;
using Microsoft.AspNetCore.Mvc;

namespace Fiap.Web.Aula02.Controllers
{
    public class VeiculoController : Controller
    {
        //Lista para gravar os veiculos
        private static IList<Veiculo> _lista = new List<Veiculo>();

        //TAREFA!
        //Cadastrar o veiculo na lista
        //Usar o index para exibir todos os veiculos em uma tabela HTML

        public IActionResult Index()
        {            
            return View(_lista); //Envia a lista para a view
        }

        [HttpGet]
        public IActionResult Cadastrar()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Cadastrar(Veiculo veiculo)
        {
            //Cadastrar na lista
            _lista.Add(veiculo);
            //Mostrar uma mensagem de sucesso
            TempData["mensagem"] = "Veículo cadastrado!";
            return RedirectToAction("Cadastrar"); //Nome do método
        }
    }
}
