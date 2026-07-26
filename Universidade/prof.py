class prof:
    def __init__(self, nome, cpf, matricula):
        self.nome = nome
        self.cpf = cpf
        self.matricula = matricula

    def getNome(self):
        return self.nome

    def getCPF(self):
        return self.cpf

    def getMatricula(self):
        return self.matricula

    def setNome(self, nome):
        self.nome = nome

    def setCPF(self, cpf):
        self.cpf = cpf

    def setMatricula(self, matricula):
        self.matricula = matricula

    def __str__(self):
        return f"Nome: {self.nome}, Matricula: {self.matricula}, CPF: {self.cpf}"

Abrantes = prof("Abrantes", "1233456789-00", "824757242")
print(Abrantes)

Erlon = prof("Erlon", "129203435-81", "3457457343")

Vinicius = prof("Vinicius", "213543655-43", "214988594435")

Susi = prof("Susi", "123930340-11", "23423429")

Fabricio = prof("Fabricio", "234.234.123-23", "2344234")

Marcos = prof("Marcos", "234342234-23", "34342342")