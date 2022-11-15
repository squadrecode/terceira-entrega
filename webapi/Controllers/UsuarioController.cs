using Microsoft.AspNetCore.Mvc;

namespace alunoapi.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class UsuarioController : ControllerBase
    {
        [HttpGet]
        public string Hello (){
            return "Olá";
        }
    }
}