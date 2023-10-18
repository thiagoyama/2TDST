using System;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace Fiap.Web.Aula03.Migrations
{
    /// <inheritdoc />
    public partial class Relacionamentos : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.AddColumn<int>(
                name: "ProdutoraId",
                table: "Tb_Filme",
                type: "int",
                nullable: false,
                defaultValue: 0);

            migrationBuilder.CreateTable(
                name: "Tbl_Ator",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Nome = table.Column<string>(type: "nvarchar(80)", maxLength: 80, nullable: false),
                    DataNascimento = table.Column<DateTime>(type: "datetime2", nullable: false),
                    Nacionalidade = table.Column<int>(type: "int", nullable: false),
                    Premiado = table.Column<bool>(type: "bit", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Tbl_Ator", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Tbl_Presidente",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Nome = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    DataNascimento = table.Column<DateTime>(type: "datetime2", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Tbl_Presidente", x => x.Id);
                });

            migrationBuilder.CreateTable(
                name: "Tbl_Filme_Ator",
                columns: table => new
                {
                    FilmeId = table.Column<int>(type: "int", nullable: false),
                    AtorId = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Tbl_Filme_Ator", x => new { x.AtorId, x.FilmeId });
                    table.ForeignKey(
                        name: "FK_Tbl_Filme_Ator_Tb_Filme_FilmeId",
                        column: x => x.FilmeId,
                        principalTable: "Tb_Filme",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Tbl_Filme_Ator_Tbl_Ator_AtorId",
                        column: x => x.AtorId,
                        principalTable: "Tbl_Ator",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "Tbl_Produtora",
                columns: table => new
                {
                    Id = table.Column<int>(type: "int", nullable: false)
                        .Annotation("SqlServer:Identity", "1, 1"),
                    Nome = table.Column<string>(type: "nvarchar(max)", nullable: false),
                    Premios = table.Column<int>(type: "int", nullable: false),
                    Ativo = table.Column<bool>(type: "bit", nullable: false),
                    PresidenteId = table.Column<int>(type: "int", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Tbl_Produtora", x => x.Id);
                    table.ForeignKey(
                        name: "FK_Tbl_Produtora_Tbl_Presidente_PresidenteId",
                        column: x => x.PresidenteId,
                        principalTable: "Tbl_Presidente",
                        principalColumn: "Id",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateIndex(
                name: "IX_Tb_Filme_ProdutoraId",
                table: "Tb_Filme",
                column: "ProdutoraId");

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_Filme_Ator_FilmeId",
                table: "Tbl_Filme_Ator",
                column: "FilmeId");

            migrationBuilder.CreateIndex(
                name: "IX_Tbl_Produtora_PresidenteId",
                table: "Tbl_Produtora",
                column: "PresidenteId");

            migrationBuilder.AddForeignKey(
                name: "FK_Tb_Filme_Tbl_Produtora_ProdutoraId",
                table: "Tb_Filme",
                column: "ProdutoraId",
                principalTable: "Tbl_Produtora",
                principalColumn: "Id",
                onDelete: ReferentialAction.Cascade);
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Tb_Filme_Tbl_Produtora_ProdutoraId",
                table: "Tb_Filme");

            migrationBuilder.DropTable(
                name: "Tbl_Filme_Ator");

            migrationBuilder.DropTable(
                name: "Tbl_Produtora");

            migrationBuilder.DropTable(
                name: "Tbl_Ator");

            migrationBuilder.DropTable(
                name: "Tbl_Presidente");

            migrationBuilder.DropIndex(
                name: "IX_Tb_Filme_ProdutoraId",
                table: "Tb_Filme");

            migrationBuilder.DropColumn(
                name: "ProdutoraId",
                table: "Tb_Filme");
        }
    }
}
