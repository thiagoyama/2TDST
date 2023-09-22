using Fiap.Web.Aula02.Models;
using Microsoft.AspNetCore.Mvc;

namespace Fiap.Web.Aula02.Controllers
{
    public class VeiculoController : Controller
    {
        //Lista para gravar os veiculos
        private static IList<Veiculo> _lista = new List<Veiculo>();
        private static int _id = 0;

        [HttpPost]
        public IActionResult Remover(int id)
        {
            //Remove o veiculo da lista (pesquisando o veiculo pelo id)
            _lista.Remove(_lista.First(v => v.Id == id));
            //Mensagem de sucesso
            TempData["msg"] = "Veiculo removido!";
            //Redirect para a Index
            return RedirectToAction("Index");
        }

        public IActionResult Index()
        {            
            return View(_lista); //Envia a lista para a view
        }

        [HttpGet]
        public IActionResult Editar(int id)
        {
            //Pesquisar o veiculo pelo ID
            var veiculo = _lista.First(v => v.Id == id);
            //Enviar o objeto Veiculo para a View
            return View(veiculo);
        }

        [HttpPost]
        public IActionResult Editar(Veiculo veiculo)
        {
            //Atualizar o veiculo na lista
            //Pesquisar a posição do veiculo na lista
            var index = _lista.ToList().FindIndex(v => v.Id == veiculo.Id);
            //Atualiza o veiculo na lista, adicionando o novo veiculo na posição do veiculo antigo
            _lista[index] = veiculo;
            //Enviar uma mensagem para view
            TempData["msg"] = "Veículo Atualizado!";
            //Redirect para a listagem (index)
            return RedirectToAction("Index");
        }

        [HttpGet]
        public IActionResult Cadastrar()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Cadastrar(Veiculo veiculo)
        {
            veiculo.Id = ++_id;
            //Cadastrar na lista
            _lista.Add(veiculo);
            //Mostrar uma mensagem de sucesso
            TempData["mensagem"] = "Veículo cadastrado!";
            return RedirectToAction("Cadastrar"); //Nome do método
        }
    }
}
