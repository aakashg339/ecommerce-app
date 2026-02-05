import { Button, Dialog, DialogBackdrop, DialogPanel, DialogTitle } from '@headlessui/react'
import { useState } from 'react'

function ProductViewModal({open, setOpen, product, isAvailable}) {
    const {id, productName, image, description, quantity, price, discount, specialPrice} = product;

    const handleClickOpen = () => {
        setOpen(true);
    };

    return (
    <>
        <Dialog open={open} as="div" className="relative z-10" onClose={close} __demoMode>
            <DialogBackdrop className="fixed inset-0 bg-gray-500 bg-opacity-75 transition-opacity" />
            <div className="fixed inset-0 z-10 w-screen overflow-y-auto">
                <div className="flex min-h-full items-center justify-center p-4">
                    <DialogPanel
                        transition
                        className="w-full max-w-md rounded-xl bg-white/5 p-6 backdrop-blur-2xl duration-300 ease-out data-closed:transform-[scale(95%)] data-closed:opacity-0"
                    >
                        <DialogTitle as="h3" className="text-base/7 font-medium text-slate-800">
                        {productName}
                        </DialogTitle>
                        <p className="mt-2 text-sm/6 text-slate-600">
                        {description}
                        </p>
                        <div className="mt-4">
                        <Button
                            className="inline-flex items-center gap-2 rounded-md bg-gray-700 px-3 py-1.5 text-sm/6 font-semibold text-white shadow-inner shadow-white/10 focus:not-data-focus:outline-none data-focus:outline data-focus:outline-white data-hover:bg-gray-600 data-open:bg-gray-700"
                            onClick={() => setOpen(false)}
                        >
                            Got it, thanks!
                        </Button>
                        </div>
                    </DialogPanel>
                </div>
            </div>
        </Dialog>
    </>
    )
}

export default ProductViewModal;