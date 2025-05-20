const urlBase = window.location.href + 'api'
//Tratando o login
document.getElementById('formLogin').addEventListener('submit', function(event){
    event.preventDefault()//evita o recarregamento default
    const msgModal = new bootstrap.Modal(document.getElementById('modalMensagem'))
    //Obtendo os dados do formulário
    const login = document.getElementById('login').value
    const senha = document.getElementById('senha').value
    //criando o objeto para a autenticação
    const dadosLogin = {
        email: login,
        senha: senha
    }
    //Efetuar o POST no endpoint de login
    fetch(`${urlBase}/usuarios/login`, {
        method: 'POST',
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(dadosLogin)
    })
    .then(response => response.json()) //garante a resposta está em JSON
    .then(data => { //Veio algo na resposta?
   if(data.access_token){ //Verifica se o token foi retornado
        //armazenamos o token no LocalStorage
        localStorage.setItem('token', data.access_token)
        window.location.href = 'municipios.html'
    } else if(data.errors) { //existem erros?
        //vamos pegar os erros da API
        const errorMessages = data.errors.map(error => error.msg).join('<br>')
        //Alteramos a mensagem no modal
        document.getElementById('mensagem').innerHTML = `<span class='text-danger'>${errorMessages}</span>`
    }
    msgModal.show()
    })
})