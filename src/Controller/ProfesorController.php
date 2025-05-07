<?php

namespace App\Controller;

use App\Repository\ProfesorRepository;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\HttpFoundation\Request;
use App\Entity\Profesor;
use Doctrine\ORM\EntityManager;
use Doctrine\ORM\EntityManagerInterface;

#[Route('/control12api/profesor')]
class ProfesorController extends AbstractController
{
    private ProfesorRepository $profesorRepository;
    private EntityManagerInterface $entityManager;


    public function __construct(ProfesorRepository $profesorRepository, EntityManagerInterface $entityManager)
    {
        $this->profesorRepository = $profesorRepository;
        $this->entityManager = $entityManager;
    
    
        
    }

    #[Route('/todos', name: 'app_profesores')]
    public function profesores(): JsonResponse
    {
        $profesores = $this->profesorRepository->findAll();
        return $this->json($profesores);
    }

    #[Route('/nuevo-profesor', name: 'app_nuevo_profesor', methods: ['POST'])]
    public function nuevoProfesor(Request $request): JsonResponse
    {
        try{
            $data = json_decode($request->getContent(), true);

        
        $profesor = new Profesor();
        $profesor->setNombre($data['nombre']);
        $profesor->setApellidos($data['apellidos']);
        $profesor->setTelefono1($data['telefono1']);
        $profesor->setTelefono2($data['telefono2'] ?? null);
        $profesor->setEmail($data['email']);
        $profesor->setNombreUsuario($data['nombreUsuario']);
        $profesor->setContrasena($data['contrasena']);
        $profesor->setFoto($data['foto'] ?? null);

        $this->profesorRepository->save($profesor, true);
        }catch(\Exception $e){
            return $this->json(['status' => 'Error creating profesor'.$e], JsonResponse::HTTP_CREATED);
        }
        

        return $this->json(['status' => 'Profesor created!'], JsonResponse::HTTP_CREATED);
    }


    #[Route('/modificar-profesor', name: 'app_modificar_profesor', methods: ['POST'])]
    public function modificarProfesor(Request $request): JsonResponse
    {
        try{
            $data = json_decode($request->getContent(), true);

        
        $profesor = $this->profesorRepository->find($data['id']);
        $profesor->setNombre($data['nombre']);
        $profesor->setApellidos($data['apellidos']);
        $profesor->setTelefono1($data['telefono1']);
        $profesor->setTelefono2($data['telefono2'] ?? null);
        $profesor->setEmail($data['email']);
        $profesor->setNombreUsuario($data['nombreUsuario']);
        $profesor->setContrasena($data['contrasena']);
        $profesor->setFoto($data['foto'] ?? null);

        $this->profesorRepository->save($profesor, true);
        }catch(\Exception $e){
            return $this->json(['status' => 'Error updating profesor'.$e], JsonResponse::HTTP_CREATED);
        }
        

        return $this->json(['status' => 'Profesor created!'], JsonResponse::HTTP_CREATED);
    }



    #[Route('/eliminar-profesor', name: 'app_eliminar_profesor', methods: ['POST'])]
    public function eliminarProfesor(Request $request): JsonResponse
    {
        try{
            $data = json_decode($request->getContent(), true);

        
        $profesor = $this->profesorRepository->find($data['id']);
        $this->entityManager->remove($profesor, true);
        $this->profesorRepository->flush();
        
        }catch(\Exception $e){
            return $this->json(['status' => 'Error deleting profesor'.$e], JsonResponse::HTTP_CREATED);
        }
        

        return $this->json(['status' => 'Profesor deleted!'], JsonResponse::HTTP_CREATED);
    }

/*Añade nuevas acciones aqui!!!!!! si no peta*/

    #[Route('/{id}', name: 'app_profesor')]
    public function profesor($id): JsonResponse
    {
        $profesor = $this->profesorRepository->find($id);
        return $this->json($profesor);
    }

    #[Route('/nombre/{nombre}', name: 'app_profesor_nombre')]
    public function profesorNombre($nombre): JsonResponse
    {
        $profesor = $this->profesorRepository->findOneBy(['nombre' => $nombre]);
        return $this->json($profesor);
    }

    #[Route('/apellidos/{apellidos}', name: 'app_profesor_apellidos')]
    public function profesorApellidos($apellidos): JsonResponse
    {
       // $profesor = $this->profesorRepository->findOneBy(['apellidos' => $apellidos]);
        $profesor = $this->profesorRepository->findByApellidos($apellidos);
        return $this->json($profesor);
    }


    #[Route('/nombre/{nombre}/apellidos/{apellidos}', name: 'app_profesor_nombre_apellidos')]
    public function profesorNombreApellidos($nombre, $apellidos): JsonResponse
    {
        $profesor = $this->profesorRepository->findOneBy(['nombre' => $nombre, 'apellidos' => $apellidos]);
        return $this->json($profesor);
    }

}
