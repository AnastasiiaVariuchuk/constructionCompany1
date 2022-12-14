package main.constructionCompany.reserves.material.catalog;

import main.constructionCompany.myExceptions.NoSuchElementException;
import main.constructionCompany.reserves.material.Material;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MaterialCatalog implements IMaterialCatalog {
    private Set<Material> materialSet = new HashSet<>();
    private static final MaterialCatalog MATERIAL_CATALOG= new MaterialCatalog();

    public MaterialCatalog(){
    }

    public static MaterialCatalog getMaterialCatalog() {
        return MATERIAL_CATALOG;
    }

    public Set<Material> getMaterialSet() {
        return materialSet;
    }

    @Override
    public Material addMaterial(Material material) {
        materialSet.add(material);
        return material;
    }

    @Override
    public Material findMaterialByName(String name) {
        Material material = materialSet.stream().filter(material1 -> material1.getName().equals(name)).findAny()
                .orElse(null);
        if(material == null) {
            throw new NoSuchElementException("There was no such material" + name);
        }
        return material;
    }

    @Override
    public List<Material> findMaterialByType(String type) {
        List<Material> materials = materialSet.stream()
                .filter(material1 -> material1.getType().equals(type))
                .collect(Collectors.toList());
        if(materials == null) {
            throw new NoSuchElementException("There was no such materials" + materials);
        }
        return materials;
    }

    @Override
    public Set<Material> deleteMaterial(Material material) {
        if (materialSet.contains(material)) {
            materialSet.remove(material);
        } else {
            throw new NoSuchElementException("There was no such material");
        }
        return materialSet;
    }

    public List<Material> toList() {
        List<Material> list = new ArrayList<>();
        for (Material element : materialSet) {
            list.add(element);
        }
        return list;
    }
}
