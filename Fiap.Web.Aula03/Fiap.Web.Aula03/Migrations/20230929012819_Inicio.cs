using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Fiap.Web.Aula03.Migrations
{
    /// <inheritdoc />
    public partial class Inicio : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Tb_Filme",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Titulo = table.Column<string>(type: "nvarchar(40)", maxLength: 40, nullable: false),
                    Sinopse = table.Column<string>(type: "nvarchar(100)", maxLength: 100, nullable: true),
                    Categoria = table.Column<int>(type: "int", nullable: false),
                    Dt_Lancamento = table.Column<DateTime>(type: "datetime2", nullable: false),
                    Disponivel = table.Column<bool>(type: "bit", nullable: false),
                    Duracao = table.Column<int>(type: "int", nullable: false),
                    Bilheteria = table.Column<decimal>(type: "decimal(18,2)", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Tb_Filme", x => x.Id);
                });
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Tb_Filme");
        }
    }
}
