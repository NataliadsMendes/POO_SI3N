class department:
    def __init__(self, nome="", codigo="", limite_prof=5):
        self.nome = nome
        self.codigo = codigo
        self.limite_prof = limite_prof
        self.profs = []

    def getNome(self):
        return self.nome

    def getCodigo(self):
        return self.codigo

    def getLimite_prof(self):
        return self.Limite_prof

    def adicionar_prof(self, prof):
        if len(self.profs) < self.limite_prof:
            self.profs.append(prof)


    # def __str__(self):
    #    return f"Nome {self.nome}, Codigo: {self.codigo}, Limite de Professores: {self.codigo}"

    def __str__(self):
        profs = '\n  '.join(str(prof) for prof in self.profs)
        return f"Departamento: {self.nome}, Código: {self.codigo}\nProfessores:\n  {profs}"

    depto_computacao = department("Departamento de Computação", "Depto_Compu", 10)
    depto_computacao.adicionar_prof(Erlon)
    depto_computacao.adicionar_prof(Vinicius)
    depto_computacao.adicionar_prof(Abrantes)

    print(depto_computacao)

    depto_ia = department("Departamento de IA", "Depto_IA", 34)
    depto_ia.adicionar_prof(Susi)
    depto_ia.adicionar_prof(Marcos)
    depto_ia.adicionar_prof(Fabricio)
