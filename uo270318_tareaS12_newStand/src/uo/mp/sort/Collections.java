package uo.mp.sort;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Collections {

	/**
	 * Ordena una lista recibida como parámetro El criterio de ordenación está
	 * implementado en el método compareTo que deben tener los objetos de la lista
	 * 
	 * @param <T>
	 * 
	 * @param list
	 *            la lista a ordenar
	 */

	public static <T> void sort(List<T> list) {
		List<T> sortedList = new LinkedList<>();

		for (T obj : list) {
			sortedList.add(findPosition(obj, sortedList), obj);
		}

		// el paso de parámetros en Java es por copia luego es necesaro que la lista
		// recibida quede ordenada

		makeCopy(sortedList, list);

	}

	/**
	 * Busca la posición en la que se debe incluir el elemento en la lista ordenada
	 * para que esta siga estando ordenada. El criterio de ordenación viene definido
	 * en el método compareTo de los elementos a ordenar
	 * 
	 * @param <T>
	 * 
	 * @param element
	 * @param sorted
	 * @return
	 */

	@SuppressWarnings("unchecked")
	private static <T> int findPosition(T obj, List<T> sortedList) {
		for (int i = 0; i < sortedList.size(); i++) {
			T o1 = sortedList.get(i);
			if (((Comparable<T>) o1).compareTo(obj) > 0) {
				return i;
			}
		}
		return sortedList.size();
	}

	/**
	 * Copia en la lista destino el contenido de la lista origen
	 * 
	 * @param sortedList
	 * @param list
	 */
	private static <T> void makeCopy(List<T> sortedList, List<T> list) {
		list.clear();
		for (T element : sortedList) {
			list.add(element);
		}
	}

	// -----------------------------------------------------------------------------

	/**
	 * Ordena una lista recibida como parámetro segun el criterio del objeto
	 * comparador que se recibe en la llamada. El criterio de ordenación está
	 * implementado en el método compareTo que deben tener los objetos de la lista
	 * 
	 * @param <T>
	 * 
	 * @param list
	 *            la lista a ordenar
	 */

	public static <T> void sort(List<T> list, Comparator<T> comparator) {
		List<T> sortedList = new LinkedList<>();

		for (T obj : list) {
			sortedList.add(findPosition(obj, sortedList,comparator), obj);
		}

		// el paso de parámetros en Java es por copia luego es necesaro que la lista
		// recibida quede ordenada

		makeCopy(sortedList, list);

	}

	private static <T> int findPosition(T obj, List<T> sortedList, Comparator<T> comparator) {
		for (int i = 0; i < sortedList.size(); i++) {
			T o1 = sortedList.get(i);
			if ((comparator.compare(o1,obj)>0)) {
				return i;
			}
		}
		return sortedList.size();
	}

}
