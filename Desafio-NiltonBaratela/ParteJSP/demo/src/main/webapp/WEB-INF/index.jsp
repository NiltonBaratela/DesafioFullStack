<!DOCTYPE html>
<html lang="pt-BR">
<head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/button.css">
        <link rel="stylesheet" href="css/records.css">
        <link rel="stylesheet" href="css/modal.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
        <title>Menu</title>
</head>
<body>
        <header>
                <form action='index.jsp'>
                        <button type="submit" class="button home" id="cadastrarEmpresa" 
                        onclick="cadastroEmpresa.html"><i  type="submit" class="fa fa-home"></i></button> 
		</form>
                <h1>Menu inicial</h1>
        </header>
        <main>
                <form class="form initial" id="cadastrarEmpresa" action='cadastroEmpresa.html'>
			<button type="submit" class="button blue initial" id="cadastrarEmpresa" 
                        onclick="cadastroEmpresa.html">Empresas</button>
		</form>
                <form class="form initial" id="cadastrarFornecedor" action='cadastroFornecedor.html'>
                        <button type="submit" class="button blue initial" id="cadastrarEmpresa" 
                        onclick="cadastroFornecedor.html">Forncedores</button>
		</form>

        </main>
        <footer>
                Copyright &copy; Candidato Nilton Baratela
        </footer>
</body>
</html>