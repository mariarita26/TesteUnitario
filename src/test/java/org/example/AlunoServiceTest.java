package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {

    @InjectMocks
    private AlunoService alunoService;

    @Mock
    private AlunoDAO alunoDAO;

    @Test
    public void NaoDeveInserirAlunoComMatriculaExistente(){
        Aluno aluno1 = new Aluno(1, "Maria", 22, "20211370005", "256");
        Mockito.doReturn(true).when(alunoDAO).existeMatriculaAtiva("20211370005");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno1));

    }

    @Test
    public void NaoDeveInserirAlunoComCPFExistente(){
        Aluno aluno1 = new Aluno(1, "Maria", 22, "20211370005", "256");
        Mockito.doReturn(true).when(alunoDAO).existeAlunoComCPF("256");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno1));
    }

    @Test void NaoDeveInserirAlunoMenorQueDezoitoAnos(){
        Aluno aluno1 = new Aluno(1, "Maria", 11, "20211370005", "256");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno1));
    }
}
