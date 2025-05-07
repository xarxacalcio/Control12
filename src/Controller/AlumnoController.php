<?php

namespace App\Controller;

use App\Repository\AlumnoRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\HttpFoundation\Request;
use App\Entity\Alumno;
use Doctrine\ORM\EntityManagerInterface;

#[Route('/control12api/alumno', name: 'app_alumno')]
class AlumnoController extends AbstractController
{
    private AlumnoRepository $alumnoRepository;

    private EntityManagerInterface $entityManager;

    public function __construct(AlumnoRepository $alumnoRepository, EntityManagerInterface $entityManager)
    {
        $this->alumnoRepository = $alumnoRepository;
        $this->entityManager = $entityManager;
    }

    #[Route('/todos', name: 'app_alumnos')]
    public function alumnos(): JsonResponse
    {
        $alumnos = $this->alumnoRepository->findAll();
        return $this->json($alumnos);
    }


    #[Route('/nuevo-alumno', name: 'app_nuevo_alumno', methods: ['POST'])]
    public function nuevoProfesor(Request $request): JsonResponse
    {
        try{
            $data = json_decode($request->getContent(), true);

        
        $alumno = new Alumno();
        $alumno->setNombre($data['nombre']);
        $alumno->setApellidos($data['apellidos']);
        $alumno->setTelefono1($data['telefono1']);
        $alumno->setTelefono2($data['telefono2'] ?? null);
        $alumno->setEmail($data['email']);
        $alumno->setFechaNacimiento(new \DateTime($data['fechaNacimiento']));
        $alumno->setFechaAlta(new \DateTime($data['fechaAlta']));


        $this->alumnoRepository->save($alumno, true);
        }catch(\Exception $e){
            return $this->json(['status' => 'Error creating alumno'.$e], JsonResponse::HTTP_CREATED);
        }
        

        return $this->json(['status' => 'Alumno created!'], JsonResponse::HTTP_CREATED);
    }



    #[Route('/vertodos', name: 'app_alumno_vertodos')]
    public function vertodos(): JsonResponse
    {
        $alumnos = $this->alumnoRepository->findAll();
        return $this->json($alumnos);
    }

    #[Route('/modificar-alumno', name: 'app_modificar_alumno', methods: ['POST'])]
    public function modificarAlumno(Request $request): JsonResponse
    {
        try {
            $data = json_decode($request->getContent(), true);

            $alumno = $this->alumnoRepository->find($data['id']);
            if (!$alumno) {
                return $this->json(['status' => 'Alumno no encontrado'], JsonResponse::HTTP_NOT_FOUND);
            }

            if (isset($data['nombre'])) {
                $alumno->setNombre($data['nombre']);
            }
            if (isset($data['apellidos'])) {
                $alumno->setApellidos($data['apellidos']);
            }
            if (isset($data['telefono1'])) {
                $alumno->setTelefono1($data['telefono1']);
            }
            if (isset($data['telefono2'])) {
                $alumno->setTelefono2($data['telefono2']);
            }
            if (isset($data['email'])) {
                $alumno->setEmail($data['email']);
            }
            if (isset($data['fechaNacimiento'])) {
                $alumno->setFechaNacimiento(new \DateTime($data['fechaNacimiento']));
            }
            if (isset($data['fechaAlta'])) {
                $alumno->setFechaAlta(new \DateTime($data['fechaAlta']));
            }

            $this->alumnoRepository->save($alumno, true);

            return $this->json(['status' => 'Alumno modificado!'], JsonResponse::HTTP_OK);
        } catch (\Exception $e) {
            return $this->json(['status' => 'Error al modificar alumno: ' . $e->getMessage()], JsonResponse::HTTP_BAD_REQUEST);
        }
    }
    #[Route('/eliminar-alumno', name: 'app_eliminar_alumno', methods: ['POST'])]
    public function eliminarAlumno(Request $request): JsonResponse
    {
        try {
            $data = json_decode($request->getContent(), true);

            $alumno = $this->alumnoRepository->find($data['id']);
            if (!$alumno) {
                return $this->json(['status' => 'Alumno no encontrado'], JsonResponse::HTTP_NOT_FOUND);
            }

            $this->entityManager->remove($alumno, true);
            $this->alumnoRepository->flush();

            return $this->json(['status' => 'Alumno eliminado!'], JsonResponse::HTTP_OK);
        } catch (\Exception $e) {
            return $this->json(['status' => 'Error al eliminar alumno: ' . $e->getMessage()], JsonResponse::HTTP_BAD_REQUEST);
        }
    }

    #[Route('/{id}', name: 'app_alumno')]
    public function alumno($id): JsonResponse
    {
        try {
            $alumno = $this->alumnoRepository->find($id);
            if (!$alumno) {
                return $this->json(['status' => 'Alumno no encontrado'], JsonResponse::HTTP_NOT_FOUND);
            }
            return $this->json($alumno);
        } catch (\Exception $e) {
            return $this->json(['status' => 'Error al obtener alumno: ' . $e->getMessage()], JsonResponse::HTTP_BAD_REQUEST);
        }
    }

    #[Route('/nombre/{nombre}', name: 'app_alumno_nombre')]
    public function alumnoNombre($nombre): JsonResponse
    {
        try {
            $alumno = $this->alumnoRepository->findOneBy(['nombre' => $nombre]);
            if (!$alumno) {
                return $this->json(['status' => 'Alumno no encontrado'], JsonResponse::HTTP_NOT_FOUND);
            }
            return $this->json($alumno);
        } catch (\Exception $e) {
            return $this->json(['status' => 'Error al obtener alumno: ' . $e->getMessage()], JsonResponse::HTTP_BAD_REQUEST);
        }
    }

    #[Route('/apellidos/{apellidos}', name: 'app_alumno_apellidos')]
    public function alumnoApellidos($apellidos): JsonResponse
    {
        try {
            $alumnos = $this->alumnoRepository->findBy(['apellidos' => $apellidos]);
            if (empty($alumnos)) {
                return $this->json(['status' => 'No se encontraron alumnos con ese apellido'], JsonResponse::HTTP_NOT_FOUND);
            }
            return $this->json($alumnos);
        } catch (\Exception $e) {
            return $this->json(['status' => 'Error al obtener alumnos por apellidos: ' . $e->getMessage()], JsonResponse::HTTP_BAD_REQUEST);
        }
    }

    #[Route('/nombre/{nombre}/apellidos/{apellidos}', name: 'app_alumno_nombre_apellidos')]
    public function alumnoNombreApellidos($nombre, $apellidos): JsonResponse
    {
        try {
            $alumno = $this->alumnoRepository->findOneBy(['nombre' => $nombre, 'apellidos' => $apellidos]);
            if (!$alumno) {
                return $this->json(['status' => 'Alumno no encontrado'], JsonResponse::HTTP_NOT_FOUND);
            }
            return $this->json($alumno);
        } catch (\Exception $e) {
            return $this->json(['status' => 'Error al obtener alumno por nombre y apellidos: ' . $e->getMessage()], JsonResponse::HTTP_BAD_REQUEST);
        }
    }


}
