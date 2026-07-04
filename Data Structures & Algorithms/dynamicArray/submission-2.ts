class DynamicArray {
    private array: number[];

    /**
     * @constructor
     * @param {number} capacity
     */
    constructor(capacity: number) {
        this.array = Array(capacity);
    }

    /**
     * @param {number} i
     * @returns {number}
     */
    get(i: number): number {
        return this.array[i];
    }

    /**
     * @param {number} i
     * @param {number} n
     * @returns {void}
     */
    set(i: number, n: number): void {
        this.array[i] = n;
    }

    /**
     * @param {number} n
     * @returns {void}
     */
    pushback(n: number): void {
        const needsResize = (this.getSize() + 1) > this.getCapacity();

        // Resize if too small
        if (needsResize) this.resize();

        this.array[this.getSize()] = n;
    }

    /**
     * @returns {number}
     */
    popback(): number {
        const endVal = this.array[this.getSize() - 1];
        this.array[this.getSize() - 1] = undefined;
        return endVal;
    }

    /**
     * @returns {void}
     */
    resize(): void {
        const resizedArray = Array((this.getCapacity() || 0) * 2);
        
        for (let i = 0; i < this.getCapacity(); i++) {
            resizedArray[i] = this.array[i]
        }
        this.array = resizedArray;
     }

    /**
     * @returns {number}
     */
    getSize(): number {
        // Filters empty slots
        let size = 0;
        for (let i = 0; i < this.array.length; i++) {
            const item = this.array[i];
            if (item !== undefined) size++;
        }

        return size;
    }

    /**
     * @returns {number}
     */
    getCapacity(): number {
        return this.array.length;
    }
}
