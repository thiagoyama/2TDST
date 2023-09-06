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
            return View();
        }

        public IActionResult Cadastrar()
        {
            return View();
        }
    }
}
