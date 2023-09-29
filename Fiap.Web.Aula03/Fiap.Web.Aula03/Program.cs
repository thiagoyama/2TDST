using Fiap.Web.Aula03.DataBase;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllersWithViews();

//Recuperar a string de conexao do arquivo appsettings.json
var conn = builder.Configuration.GetConnectionString("conexao");

//Configurar o serviço de injeção de dependência do DbContext
builder.Services.AddDbContext<StreamingContext>(op => op.UseSqlServer(conn));

var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
}
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.Run();
